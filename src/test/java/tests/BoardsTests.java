package tests;

import data.DP_ForBoard;
import manager.HelperBoards;
import manager.HelperLogin;
import models.BoardDTO;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Random;

public class BoardsTests extends TestBase implements HelperBoards, HelperLogin {

    @BeforeClass(alwaysRun = true)
    public void login(){
        clickButtonLogin();
        UserDTO user = UserDTO.builder()
                .email(getEmail())
                .password(getPassword())
                .build();
        logger.info("Test data --> " + user.toString());
        typeLogin(user.getEmail());
        clickButtonContinue();
        typePassword(user.getPassword());
        clickButtonLoginForm();

    }

    @Test(dataProvider = "dp_createBoardPositiveTest", dataProviderClass = DP_ForBoard.class, groups = {"positive", "smoke"})
    public void createBoardPositiveTest(BoardDTO board){
//        int i = new Random().nextInt(1000)+1000;
//        BoardDTO board = BoardDTO.builder()
//                .boardTitle("Alex_"+i)
//                .build();
        createBoard(board);
        System.out.println(board.toString());
        System.out.println(isTextInElementPresent_boardNameDisplay());
        Assert.assertEquals(isTextInElementPresent_boardNameDisplay(), board.getBoardTitle());

    }

    @Test(dataProvider = "dpFile_createBoardPositiveTest", dataProviderClass = DP_ForBoard.class)
    public void createBoardPositiveTest_dpFile(BoardDTO board){
        createBoard(board);
        System.out.println(board.toString());
        System.out.println(isTextInElementPresent_boardNameDisplay());
        Assert.assertEquals(isTextInElementPresent_boardNameDisplay(), board.getBoardTitle());

    }

    @Test(groups = {"negative"})
    public void deleteBordPositiveTest(){
        int i = new Random().nextInt(1000)+1000;
        BoardDTO board = BoardDTO.builder()
                .boardTitle("Alex_del"+i)
                .build();
        createBoard(board);
        System.out.println(board.toString());
        System.out.println(isTextInElementPresent_boardNameDisplay());
        clickButtonBoards();
        clickButtonBoardWithTitle(board.getBoardTitle());
        deleteBoard();
    }

//    @AfterMethod
//    public void afterTest(){
//        clickButtonBoards();
//    }



}
