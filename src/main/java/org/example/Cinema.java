package org.example;

import java.util.Arrays;

public class Cinema {
    private final int[][][] cinema;

    public Cinema(int hall, int rowsCount, int seatsCount) {
        cinema = new int[hall][rowsCount][seatsCount];
    }

    public boolean bookSeats(int hallNumber, int row, int[] seats) {
        if(hallNumber >= cinema.length || row >= cinema[hallNumber].length ||
                (Arrays.stream(seats).max().isPresent() && Arrays.stream(seats).max().getAsInt() > cinema[hallNumber][row].length)) {
            System.out.println("You entered wrong values!");
            return false;
        }
        for (int seat: cinema[hallNumber][row]) {
            if(seat == 1) {
                System.out.println("Some of these seats are already booked!");
                return false;
            }
        }
        for (int seat: seats) {
            cinema[hallNumber][row][seat] = 1;
        }
        return true;
    }

    public boolean cancelBooking(int hallNumber, int row, int[] seats) {
        if(hallNumber >= cinema.length || row >= cinema[hallNumber].length ||
                (Arrays.stream(seats).max().isPresent() && Arrays.stream(seats).max().getAsInt() > cinema[hallNumber][row].length)) {
            System.out.println("You entered wrong values!");
            return false;
        }
        for (int seat: seats) {
            cinema[hallNumber][row][seat] = 0;
        }
        return true;
    }

    public boolean checkAvailability(int screen, int numSeats) {
        if(screen >= cinema.length || numSeats > cinema[screen][0].length) {
            System.out.println("You entered wrong values!");
            return false;
        }
        int availableSeatsCounter = 0;

        for(int i = 0; i < cinema[screen].length; i++) {
            if(Arrays.stream(cinema[screen][i]).allMatch(seat -> seat == 0)) {
                return true;
            }
            availableSeatsCounter = 0;
            for(int j = 0; j < cinema[screen][i].length - numSeats; j++) {
                if(cinema[screen][i][j] == 0) {
                    availableSeatsCounter++;
                    if(availableSeatsCounter == numSeats) {
                        return true;
                    }
                }
                else {
                    availableSeatsCounter = 0;
                }
            }
        }
        return availableSeatsCounter == numSeats;
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.print("\t\t");
        for(int i = 0; i < cinema[hallNumber][0].length; i++) {
            System.out.print(i+1 + "\t");
        }
        System.out.println();
        for (int row = 1; row <= cinema[hallNumber].length; row++) {
            if(row >= 10) {
                System.out.print("   ");
            }
            else {
                System.out.print("\t");
            }
            System.out.print(row + " |");
            for(int seat: cinema[hallNumber][row-1]) {
                System.out.print("\t" + seat);
            }
            System.out.println(" | " + row);
        }
        System.out.print("\t\t");
        for(int i = 0; i < cinema[hallNumber][0].length; i++) {
            System.out.print(i+1 + "\t");
        }
        System.out.println();
    }

    public Seats findBestAvailable(int hallNumber, int numSeats) {
        if(hallNumber >= cinema.length || numSeats > cinema[hallNumber][0].length) {
            throw new IllegalArgumentException("You entered wrong values!");
        }

        int[][] costMap = new int[cinema[hallNumber].length][cinema[hallNumber][0].length];

        for(int row = 0; row < cinema[hallNumber].length; row++) {
            for(int seat = 0; seat < cinema[hallNumber][row].length / 2; seat++) {
                costMap[row][seat] = 10 - row + seat;
            }
            for(int seat = cinema[hallNumber][row].length / 2; seat < cinema[hallNumber][row].length; seat++) {
                costMap[row][seat] = 10 - row + cinema[hallNumber][row].length - seat;
            }
        }

        for(int row = 0; row < cinema[hallNumber].length; row++) {
            for(int seat = 0; seat < cinema[hallNumber][0].length; seat++) {
                if(cinema[hallNumber][row][seat] == 1) {
                    costMap[row][seat] = -100;
                }
            }
        }

        int maxSumOfQualityIndex = 0, currentSum = 0, resultRow = -1, resultFirstSeat = -1;
        for(int row = 0; row < cinema[hallNumber].length; row++) {
            for(int seat = 0; seat < cinema[hallNumber][0].length - numSeats; seat++) {
                for(int i = seat; i < seat + numSeats; i++) {
                    currentSum += costMap[row][i];
                    if(currentSum < 0) break;
                }
                if(maxSumOfQualityIndex < currentSum) {
                    maxSumOfQualityIndex = currentSum;
                    resultRow = row;
                    resultFirstSeat = seat;
                }
                currentSum = 0;
            }
        }

        if(resultRow > -1) {
            int[] seats = new int[numSeats];
            for(int i = 0; i < numSeats; i++) {
                seats[i] = resultFirstSeat + i;
            }
            return new Seats(resultRow, seats);
        }

        System.out.println("There is no available seats in the hall!");
        return null;
    }

    public boolean autoBook(int hallNumber, int numSeats) {
        Seats bestSeats = findBestAvailable(hallNumber, numSeats);
        int[] seats = new int[numSeats];
        if (bestSeats.getSeats().length > 0) System.arraycopy(bestSeats.getSeats(), 0, seats, 0, bestSeats.getSeats().length);
        return bookSeats(hallNumber, bestSeats.getRow(), seats);
    }
}