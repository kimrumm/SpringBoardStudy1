package com.study.ansboard.service;

import com.study.ansboard.dao.BoardDAO;
import com.study.ansboard.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public int write(BoardVO boardVO) throws Exception {
        if (boardVO.getGNo() == 0) {
            return boardDAO.write(boardVO);
        } else {
            boardDAO.replyShape(boardVO);
            return boardDAO.replyWrite(boardVO);
        }
    }

    @Override
    public BoardVO view(int bNo) throws Exception {
        return boardDAO.view(bNo);
    }

    @Override
    public List<BoardVO> list() throws Exception {
        return boardDAO.list();
    }






}
