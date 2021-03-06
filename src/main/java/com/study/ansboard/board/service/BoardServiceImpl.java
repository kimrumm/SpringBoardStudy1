package com.study.ansboard.board.service;

import com.study.ansboard.board.dao.BoardDAO;
import com.study.ansboard.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    // 게시판 글 작성
    @Override
    public int write(BoardVO boardVO) throws Exception {

        if (boardVO.getgNo() == 0) {
            return boardDAO.write(boardVO);
        } else {
            boardDAO.replyShape(boardVO);
            return boardDAO.writeReply(boardVO);
        }
    }

    @Override
    public BoardVO view(int bNo) throws Exception {
        boardDAO.viewCnt(bNo);
        return boardDAO.view(bNo);
    }

    @Override
    public void update(BoardVO boardVO) {
        boardDAO.update(boardVO);
    }

    @Override
    public void delete(BoardVO boardVO) throws Exception {
        boardDAO.delete(boardVO);
    }


    @Override
    public List<BoardVO> list() throws Exception {
        return boardDAO.list();
    }




}
