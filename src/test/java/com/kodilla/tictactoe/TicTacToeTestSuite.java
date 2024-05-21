package com.kodilla.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tic Tac Toe Game Test Suite")
public class TicTacToeTestSuite {
    private TicTacToeGame game;

    @Nested
    @DisplayName("Tests for 3x3 size board for 'O' wins")
    class OwinsSmallBoard {
        @BeforeEach
        public void setUp() {
            game = new TicTacToeGame();
            game.createBoard(3, 1);
        }
        @Test
        public void testHorizontalWins() {
            for (int i = 0; i < 3; i++) {
                game.getboard()[i][0] = 'O';
                game.getboard()[i][1] = 'O';
                game.getboard()[i][2] = 'O';
                assertTrue(game.checkWin3x3());
            }
        }
        @Test
        public void testVerticalWins() {
            for (int i = 0; i < 3; i++) {
                game.getboard()[0][i] = 'O';
                game.getboard()[1][i] = 'O';
                game.getboard()[2][i] = 'O';
                assertTrue(game.checkWin3x3());
            }
        }
        @Test
        public void testDiagonalWin() {
            game.getboard()[0][0] = 'O';
            game.getboard()[1][1] = 'O';
            game.getboard()[2][2] = 'O';
            assertTrue(game.checkWin3x3());
        }
        @Test
        public void testDiagonalWin2() {
            game.getboard()[0][2] = 'O';
            game.getboard()[1][1] = 'O';
            game.getboard()[2][0] = 'O';
            assertTrue(game.checkWin3x3());
        }
    }

    @Nested
    @DisplayName("Tests for 3x3 size board for 'X' wins")
    class XwinsSmallBoard {
        @BeforeEach
        public void setUp() {
            game = new TicTacToeGame();
            game.createBoard(3, 1);
        }
        @Test
        public void testHorizontalWins() {
            for (int i = 0; i < 3; i++) {
                game.getboard()[i][0] = 'X';
                game.getboard()[i][1] = 'X';
                game.getboard()[i][2] = 'X';
                assertTrue(game.checkWin3x3());
            }
        }
        @Test
        public void testVerticalWins() {
            for (int i = 0; i < 3; i++) {
                game.getboard()[0][i] = 'X';
                game.getboard()[1][i] = 'X';
                game.getboard()[2][i] = 'X';
                assertTrue(game.checkWin3x3());
            }
        }
        @Test
        public void testDiagonalWin() {
            game.getboard()[0][0] = 'X';
            game.getboard()[1][1] = 'X';
            game.getboard()[2][2] = 'X';
            assertTrue(game.checkWin3x3());
        }
        @Test
        public void testDiagonalWin2() {
            game.getboard()[0][2] = 'X';
            game.getboard()[1][1] = 'X';
            game.getboard()[2][0] = 'X';
            assertTrue(game.checkWin3x3());
        }
    }

    @Nested
    @DisplayName("Tests for 10x10 size board for 'X' wins")
    class XwinsBigBoard {
        @BeforeEach
        public void setUp() {
            game = new TicTacToeGame();
            game.createBoard(10, 1);
        }
        @Test
        public void testHorizontalWins() {
            for (int i = 0; i < 5; i++) {
                game.getboard()[0][i] = 'X';
            }
            assertTrue(game.checkWin10x10());
        }
        @Test
        public void testVerticalWins() {
            for (int i = 0; i < 5; i++) {
                game.getboard()[i][0] = 'X';
            }
            assertTrue(game.checkWin10x10());
        }
        @Test
        public void testDiagonalWins() {
            for (int i = 0; i < 5; i++) {
                game.getboard()[i][i] = 'X';
            }
            assertTrue(game.checkWin10x10());
        }
        @Test
        public void testDiagonalWins2() {
            for (int i = 0; i < 5; i++) {
                game.getboard()[i][4 - i] = 'X';
            }
            assertTrue(game.checkWin10x10());
        }
    }

    @Nested
    @DisplayName("Tests for 10x10 size board for 'O' wins")
    class OwinsBigBoard {
        @BeforeEach
        public void setUp() {
            game = new TicTacToeGame();
            game.createBoard(10, 1);
        }
        @Test
        public void testHorizontalWins() {
            for (int i = 0; i < 5; i++) {
                game.getboard()[0][i] = 'O';
            }
            assertTrue(game.checkWin10x10());
        }
        @Test
        public void testVerticalWins() {
            for (int i = 0; i < 5; i++) {
                game.getboard()[i][0] = 'O';
            }
            assertTrue(game.checkWin10x10());
        }
        @Test
        public void testDiagonalWins() {
            for (int i = 0; i < 5; i++) {
                game.getboard()[i][i] = 'O';
            }
            assertTrue(game.checkWin10x10());
        }
        @Test
        public void testDiagonalWins2() {
            for (int i = 0; i < 5; i++) {
                game.getboard()[i][4 - i] = 'O';
            }
            assertTrue(game.checkWin10x10());
        }
    }

    @Nested
    @DisplayName("Test points for 3x3 and 10x10")
    class PointsTest {
        @Test
        public void test3x3WinWithThreePoints() {
            game = new TicTacToeGame();
            game.createBoard(3, 3);
            game.getboard()[0][0] = 'X';
            game.getboard()[1][1] = 'X';
            game.getboard()[2][2] = 'X';
            assertTrue(game.checkWin3x3());
        }
        @Test
        public void test10x10WinWithThreePoints() {
            game = new TicTacToeGame();
            game.createBoard(10, 3);
            game.getboard()[0][0] = 'X';
            game.getboard()[1][1] = 'X';
            game.getboard()[2][2] = 'X';
            game.getboard()[3][3] = 'X';
            game.getboard()[4][4] = 'X';
            assertTrue(game.checkWin10x10());
        }
    }

    @Nested
    @DisplayName("Miscellaneous tests")
    class MiscellaneousTestsSmallAndBig {
        @BeforeEach
        public void setUp() {
            game = new TicTacToeGame();
            game.createBoard(3, 1);
        }
        @Test
        public void testDraw() {
            game.getboard()[0][0] = 'X';
            game.getboard()[0][1] = 'O';
            game.getboard()[0][2] = 'X';
            game.getboard()[1][0] = 'X';
            game.getboard()[1][1] = 'O';
            game.getboard()[1][2] = 'O';
            game.getboard()[2][0] = 'O';
            game.getboard()[2][1] = 'X';
            game.getboard()[2][2] = 'X';
            assertTrue(game.isDraw());
        }
        @Test
        public void testFalseMove() {
            game.getboard()[0][0] = 'O';
            game.getboard()[0][1] = 'X';
            assertFalse(game.isMoveCorrect(0, 1));
        }
    }
}
