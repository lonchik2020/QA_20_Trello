package data;

import models.BoardDTO;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DP_ForBoard {
    @DataProvider
    public Iterator<Object[]> dp_createBoardPositiveTest(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{BoardDTO.builder().boardTitle("first").build()});
        list.add(new Object[]{BoardDTO.builder().boardTitle("second").build()});
        list.add(new Object[]{BoardDTO.builder().boardTitle("third").build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dpFile_createBoardPositiveTest() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File("src/test/resources/data_boards.csv")));
        String line = bufferedReader.readLine();
        while (line != null){
            String split = line;
            list.add(new Object[]{BoardDTO.builder().boardTitle(split).build()});
            line = bufferedReader.readLine();
        }

        return list.iterator();
    }
}
