package kr.co.Board;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class BoardTest {

    public static void main(String[] args) {
        System.out.println(123123);
        try {
            
            String resource = "config/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();
            BoardVO board = (BoardVO)session.selectOne("kr.co.Board.BoardMapper.selectBoard", 11);
            
            System.out.println(board.getName());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
