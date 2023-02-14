package com.mc.mvc.board.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.mc.mvc.board.dto.Board;
import com.mc.mvc.common.file.FileInfo;

public interface BoardService {

	void insertBoard(Board board, List<MultipartFile> files);

	FileInfo selectFileInfo(String flIdx);

	Map<String, Object> selectBoardList(int page);

	Map<String, Object> selectBoardContentByBdIdx(int bdIdx);

	void deleteBoardByBdIdx(int bdIdx);

}
