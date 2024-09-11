public class Main {
    public static void main(String[] args) {

        String[][] arr = {
                {"11", "12", "13", "14"},
                {"21", "22", "23", "24"},
                {"31", "32", "33", "34"},
                {"41", "42", "43", "44"}};

        try {
            int sum = ArrayChecker.sumOfArray(arr);
            System.out.println("Сумма значений ячеек массива: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

        public static class MyArraySizeException extends Exception {
            public MyArraySizeException(String message) {
                super(message);
            }
        }

        public static class MyArrayDataException extends Exception {

            private int row;
            private int col;

            public MyArrayDataException(String message, int row, int col) {
                super(message);
                this.row = row;
                this.col = col;
            }

            public int getRow() {
                return row;
            }

            public int getCol() {
                return col;
            }
        }

        public static class ArrayChecker extends Main {
            public static int sumOfArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
                if (arr.length != 4 || arr[0].length != 4) {
                    throw new MyArraySizeException("Некорректный размер массива");
                }

                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        try {
                            sum += Integer.parseInt(arr[i][j]);
                        } catch (NumberFormatException e) {
                            throw new MyArrayDataException("Некорректное значение в ячейке (" + i + "," + j + ")", i, j);
                        }
                    }
                }
                return sum;
            }
        }
    }