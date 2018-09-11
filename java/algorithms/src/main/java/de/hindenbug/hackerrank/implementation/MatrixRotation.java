package de.hindenbug.hackerrank.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatrixRotation {

    enum Direction {
        RowDown, ColRight, RowUp, ColLeft
    }

    static void print(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String line = String.join(" ", IntStream.of(matrix[row])
                    .mapToObj(value -> Integer.toString(value))
                    .collect(Collectors.toList()));
            System.out.println(line);
        }
    }

    static boolean inBottomLeft(int row, int col, int rows, int ring) {
        return row == rows - ring - 1 && col == ring;
    }

    static boolean inBottomRight(int row, int col, int rows, int cols, int ring) {
        return row == rows - ring - 1 && col == cols - ring - 1;
    }

    static boolean inTopRight(int row, int col, int cols, int ring) {
        return row == ring && col == cols - ring - 1;
    }

    static boolean onLeft(int col, int ring) {
        return col == ring;
    }

    static boolean onBottom(int row, int rows, int ring) {
        return row == rows - ring - 1;
    }

    static boolean onRight(int col, int cols, int ring) {
        return col == cols - ring - 1;
    }

    static boolean inLastRingCell(int row, int col, int ring) {
        return row == ring && col == ring + 1;
    }

    static Direction direction(int row, int col, int rows, int cols, int ring) {

        if (onLeft(col, ring)) {

            boolean inBottomLeft = inBottomLeft(row, col, rows, ring);
            return inBottomLeft
                   ? Direction.ColRight
                   : Direction.RowDown;
        } else if (onBottom(row, rows, ring)) {

            boolean inBottomRight = inBottomRight(row, col, rows, cols, ring);
            return inBottomRight
                   ? Direction.RowUp
                   : Direction.ColRight;
        } else if (onRight(col, cols, ring)) {

            boolean inTopRight = inTopRight(row, col, cols, ring);
            return inTopRight
                   ? Direction.ColLeft
                   : Direction.RowUp;
        } else {
            return Direction.ColLeft;
        }
    }

    static int[] targetPosition(int row, int col, int rows, int cols, int ring, int rotations) {
        int[] target = new int[]{row, col};

        for (int i = 0; i < rotations; i++) {
            target = move(target, rows, cols, ring);
        }
        return target;
    }

    static int[] move(int[] cell, int rows, int cols, int ring) {
        Direction d = direction(cell[0], cell[1], rows, cols, ring);
        switch (d) {
            case RowDown:
                cell[0]++;
                break;
            case RowUp:
                cell[0]--;
                break;
            case ColRight:
                cell[1]++;
                break;
            case ColLeft:
                cell[1]--;
                break;
        }
        return cell;
    }

    private static int neededRotations(final int rotations, final int rows, final int cols, final int ring) {

        int ringRows = rows - 2 * ring;
        int ringCols = cols - 2 * ring;
        int ringElements = 2 * ringRows + 2 * (ringCols - 2);
        int neededRotations = Math.floorMod(rotations, ringElements);
        return neededRotations;
    }

    static int[][] matrixRotation(int[][] matrix, int rotations) {

        final long start = System.currentTimeMillis();
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        final int[][] dst = new int[rows][cols];
        // constraints:
        // - min(rows, cols) % 2 == 0
        // - 2 <= rows, cols <= 300
        final int rings = Integer.min(matrix.length, matrix[0].length) / 2;

        int ring = 0;
        int neededRotations = neededRotations(rotations, rows, cols, ring);
        int[] cell = new int[]{0, 0};
        int[] target = targetPosition(cell[0], cell[1], rows, cols, ring, neededRotations);

        while (ring < rings) {

            while (!inLastRingCell(cell[0], cell[1], ring)) {

                dst[target[0]][target[1]] = matrix[cell[0]][cell[1]];

                cell = move(cell, rows, cols, ring);
                target = move(target, rows, cols, ring);
            }
            dst[target[0]][target[1]] = matrix[cell[0]][cell[1]];
            ring++;
            cell[0] = ring;
            cell[1] = ring;
            if (ring < rings) {

                neededRotations = neededRotations(rotations, rows, cols, ring);
                target = targetPosition(cell[0], cell[1], rows, cols, ring, neededRotations);
            }
        }
        long end = System.currentTimeMillis();

        print(dst);
        System.out.println("finished in: " + (end - start) + " ms");
        return dst;
    }

    static int[][] read(InputStream source) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(source))) {
            List<List<Integer>> matrix = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                matrix.add(Stream.of(values)
                        .map(s -> Integer.valueOf(s))
                        .collect(Collectors.toList()));
            }
            int[][] result = new int[matrix.size()][matrix.get(0)
                    .size()];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = matrix.get(i)
                            .get(j);
                }
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static int[][] gen(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value;
                value++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws IOException {
//        matrixRotation(gen(2, 2), 1);
//        matrixRotation(gen(4, 4), 1);
//        matrixRotation(gen(4, 7), 18);
//        matrixRotation(gen(11, 10), 1);
//        matrixRotation(new int[][]{
//                {1, 2, 3, 4},
//                {7, 8, 9, 10},
//                {13, 14, 15, 16},
//                {19, 20, 21, 22},
//                {25, 26, 27, 28},
//        }, 7);
//        matrixRotation(gen(1000, 1000), Integer.MAX_VALUE);

        InputStream input = MatrixRotation.class.getResourceAsStream("/small_matrix.csv");
        int[][] matrix = read(input);
        matrixRotation(matrix, 386);
        input.close();

//        InputStream input = MatrixRotation.class.getResourceAsStream("/large_matrix.csv");
//        matrixRotation(read(input), 212131);
//        input.close();

//        InputStream input = MatrixRotation.class.getResourceAsStream("/largest_matrix.csv");
//        int[][] matrix = read(input);
//        matrixRotation(matrix, 999999999);
//        input.close();

    }
}
