package com.study.ansboard.board.dao;

import com.study.ansboard.board.vo.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    private SqlSession sqlSession;
    private static final String namespace="com.study.ansboard.sqls.BoardMapper";

    @Override
    public List<BoardVO> getCommentList(int bNo) {
        return sqlSession.selectList(namespace+".getCommentList");
    }

    // 게시글 목록
    @Override
    public List<BoardVO> list() {
        return sqlSession.selectList(namespace+".list");
    }

    // 게시글 내용 출력
    @Override
    public BoardVO view(int bNo) {
        return sqlSession.selectOne(namespace+".view",bNo);
    }

    // 글 작성
    @Override
    public int write(BoardVO boardVO) {
        return sqlSession.insert(namespace+".write",boardVO);
    }

    //답글 순서 수정
    @Override
    public void replyShape(BoardVO boardVO) {
        sqlSession.update(namespace+".replyShape",boardVO);
    }

    // 답글 정보 조회
    public BoardVO replyInfo(BoardVO boardVO) {
        return sqlSession.selectOne(namespace+".replyInfo", boardVO);
    }

    // 답글 등록
    @Override
    public int writeReply(BoardVO boardVO) {
        return sqlSession.insert(namespace + ".writeReply", boardVO);
    }

    // 조회수 증가
    @Override
    public void viewCnt(int bNo) {
        sqlSession.update(namespace+".viewCnt", bNo);
    }

    // 게시글 수정
    @Override
    public void update(BoardVO boardVO) {
        sqlSession.update(namespace+".update", boardVO);
    }

    @Override
    public void delete(BoardVO boardVO) {
        sqlSession.delete(namespace+".delete", boardVO);
    }

    @Override
    public Integer insertComm(BoardVO boardVO) {
        sqlSession.insert(namespace + ".insertComm", boardVO);
        return null;
    }


}
