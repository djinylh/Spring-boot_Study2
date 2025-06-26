    package com.green.memoserver;


    import com.green.memoserver.model.MemoGetOneRes;
    import com.green.memoserver.model.MemoGetReq;
    import com.green.memoserver.model.MemoGetRes;
    import com.green.memoserver.model.MemoPostReq;
    import org.apache.ibatis.annotations.Mapper;


    import java.util.List;

    @Mapper
    public interface MemoMapper {
        int save(MemoPostReq p);
        //insert, update, delete는 다 int
        // 왼쪽은 Res 백엔드가 줌 오른쪽은 Req 프론트가 줌
        List<MemoGetRes> findAll(MemoGetReq p);
        MemoGetOneRes findById(int id);
        int deleteById(int id);
    }
