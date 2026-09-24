class Solution {

    static class State {
        int r, c;
        int energy;
        int mask;
        int moves;

        State(int r, int c, int energy, int mask, int moves) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;

        int litterCount = 0;

        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        // Find S and number every L
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    startR = r;
                    startC = c;
                }

                if (ch == 'L') {
                    litterId[r][c] = litterCount++;
                }
            }
        }

        int allCollected = (1 << litterCount) - 1;

        // visited[row][col][energy][mask]
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<State> queue = new ArrayDeque<>();

        visited[startR][startC][energy][0] = true;

        queue.offer(
            new State(startR, startC, energy, 0, 0)
        );

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            State cur = queue.poll();

            // All litter collected
            if (cur.mask == allCollected) {
                return cur.moves;
            }

            // If energy is 0, we can only continue from R
            if (cur.energy == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {

                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                // Boundary
                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                // Spend 1 energy for the move
                int newEnergy = cur.energy - 1;

                // Collect litter
                int newMask = cur.mask;

                if (classroom[nr].charAt(nc) == 'L') {
                    int id = litterId[nr][nc];
                    newMask |= (1 << id);
                }

                // R resets energy
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                // Mark state
                if (visited[nr][nc][newEnergy][newMask]) {
                    continue;
                }

                visited[nr][nc][newEnergy][newMask] = true;

                queue.offer(
                    new State(
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        cur.moves + 1
                    )
                );
            }
        }

        return -1;
    }
}