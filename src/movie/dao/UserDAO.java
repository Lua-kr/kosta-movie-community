package movie.dao;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
	/**
	 * 	회원 로그인
	 * */
	int userLogin() throws SQLException;
	
	
	/**
	 * 	회원 로그아웃
	 * */
	int userLogout() throws SQLException;
	
	
	/**
	 * 	회원 게시물 검색(이름)
	 * */
	int SearchBoardByName() throws SQLException;
	
	/**
	 * 	회원 게시물 검색(제목)
	 * */
	int SearchBoardByTitle() throws SQLException;
	
	/**
	 * 	회원 게시물 검색(내용)
	 * */
	int SearchBoardByContent() throws SQLException;
	
	
	/**
	 * 	회원 게시물 확인
	 * */
	
	
	
	
	
}//UserDAO