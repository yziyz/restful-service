package edu.libsys.restful.data.dao;

import edu.libsys.restful.data.mapper.BookMapper;
import edu.libsys.restful.entity.Book;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.List;

public class BookDao implements Serializable {
    public Book getBookByMarcRecId(int marcRecId) {
        Book book = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            book = bookMapper.getBookByMarcRecId(marcRecId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public int addBook(Book book) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.addBook(book);
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int updataBook(Book book) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.updataBook(book);
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int deleteBook(Book book) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.deleteBook(book);
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int countBook() {
        int count = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            count = bookMapper.countBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Book> getBookListBySearchTitle(String keyWord) {
        List<Book> bookList = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookList = bookMapper.getBookListBySearchTitle(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public List<Book> getBookList() {
        List<Book> bookList = null;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookList = bookMapper.getBookList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public int likeCountPlusOne(int id) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.likeCountPlusOne(id);
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int disLikeCountPlusOne(int id) {
        int status = 0;
        try (SqlSession sqlSession = SessionFactory.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.disLikeCountPlusOne(id);
            sqlSession.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}