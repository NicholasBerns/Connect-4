#**********************************
# Makefile for Project 4
# Nicholas Berns
#**********************************
default: cpsc2150/extendedConnectX/GameScreen.java cpsc2150/extendedConnectX/models/IGameBoard.java cpsc2150/extendedConnectX/models/AbsGameBoard.java cpsc2150/extendedConnectX/models/BoardPosition.java cpsc2150/extendedConnectX/models/GameBoard.java cpsc2150/extendedConnectX/models/GameBoardMem.java
	javac cpsc2150/extendedConnectX/GameScreen.java cpsc2150/extendedConnectX/models/IGameBoard.java cpsc2150/extendedConnectX/models/AbsGameBoard.java cpsc2150/extendedConnectX/models/BoardPosition.java cpsc2150/extendedConnectX/models/GameBoard.java cpsc2150/extendedConnectX/models/GameBoardMem.java
run: cpsc2150/extendedConnectX/GameScreen.class cpsc2150/extendedConnectX/models/IGameBoard.class cpsc2150/extendedConnectX/models/AbsGameBoard.class cpsc2150/extendedConnectX/models/BoardPosition.class cpsc2150/extendedConnectX/models/GameBoard.class cpsc2150/extendedConnectX/models/GameBoardMem.class
	java cpsc2150.extendedConnectX.GameScreen
test: cpsc2150/extendedConnectX/models/IGameBoard.java cpsc2150/extendedConnectX/models/AbsGameBoard.java cpsc2150/extendedConnectX/models/BoardPosition.java cpsc2150/extendedConnectX/models/GameBoard.java cpsc2150/extendedConnectX/models/GameBoardMem.java cpsc2150/extendedConnectX/models/TestGameBoard.java cpsc2150/extendedConnectX/models/TestGameBoardMem.java
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/extendedConnectX/models/IGameBoard.java cpsc2150/extendedConnectX/models/AbsGameBoard.java cpsc2150/extendedConnectX/models/BoardPosition.java cpsc2150/extendedConnectX/models/GameBoard.java cpsc2150/extendedConnectX/models/GameBoardMem.java cpsc2150/extendedConnectX/models/TestGameBoard.java cpsc2150/extendedConnectX/models/TestGameBoardMem.java
testGB: cpsc2150/extendedConnectX/models/IGameBoard.class cpsc2150/extendedConnectX/models/AbsGameBoard.class cpsc2150/extendedConnectX/models/BoardPosition.class cpsc2150/extendedConnectX/models/GameBoard.class cpsc2150/extendedConnectX/models/TestGameBoard.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.extendedConnectX.models.TestGameBoard
testGBmem: cpsc2150/extendedConnectX/models/IGameBoard.class cpsc2150/extendedConnectX/models/AbsGameBoard.class cpsc2150/extendedConnectX/models/BoardPosition.class cpsc2150/extendedConnectX/models/GameBoard.class cpsc2150/extendedConnectX/models/TestGameBoardMem.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.extendedConnectX.models.TestGameBoardMem
clean:
	rm -f cpsc2150/extendedConnectX/models/*.class
	rm -f cpsc2150/extendedConnectX/*.class