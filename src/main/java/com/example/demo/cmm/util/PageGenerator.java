package com.example.demo.cmm.util;

import static com.example.demo.cmm.util.Util.*;

import java.util.HashMap;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.demo.cmm.enm.Sql;

import lombok.Data;

@Component("page") @Data @Lazy
public class PageGenerator {
	private int totalCount,startRow,endRow,
				pageCount,pageSize,startPage,endPage,pageNum,
				blockCount,blockSise,nextBlock,prevBolock,BlockNum;
	
	public final int BLOCK_SIZE = 5;
	
	public int totalCount(String tablename) {
		var map = new HashMap<>();
		var count = 0;
		map.put("COUNT_STUDENTS", Sql.COUNT+tablename);
		
		return count;
	}
}
