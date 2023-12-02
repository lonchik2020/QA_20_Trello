package manager;

import models.BoardDTO;
import org.openqa.selenium.By;

public interface HelperBoards extends HelperBase{

    By buttonCreateBoard = By.xpath("//span[text()='Create new board']");

    By fieldBoardTitle = By.xpath("//input[@data-testid='create-board-title-input']");

    By buttonCreate = By.xpath("//button[@data-testid='create-board-submit-button']");

    By buttonBoards = By.xpath("//a[@data-testid='open-boards-link']");

    By boardNameDisplay = By.xpath("//h1[@data-testid='board-name-display']");

    By buttonDots = By.xpath("//button[@aria-label='Show menu']");

    By buttonCloseBoard = By.xpath("//a[@class='board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board']");

    By buttonClose = By.xpath("//input[@value='Close']");

    By buttonPermanentlyDeleteBoard = By.xpath("//button[@data-testid='close-board-delete-board-button']");

    By buttonDelete = By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']");

    default void createBoard(BoardDTO board){
        click(buttonCreateBoard);
        type(fieldBoardTitle, board.getBoardTitle());
        pause(3);
        click(buttonCreate);
    }

    default void clickButtonBoards(){
        click(buttonBoards);
    }

    default String isTextInElementPresent_boardNameDisplay(){
        return isTextInElementPresent(boardNameDisplay);
    }
    default void clickButtonBoardWithTitle(String boardTitle){
        String xPathBoard = "//div[@title='"+boardTitle+"']";
        System.out.println(xPathBoard);
        click(By.xpath(xPathBoard));
    }

    default void deleteBoard(){
        pause(3);
        click(buttonDots);
        pause(3);
        click(buttonCloseBoard);
        click(buttonClose);
        click(buttonPermanentlyDeleteBoard);
        click(buttonDelete);
    }
}
