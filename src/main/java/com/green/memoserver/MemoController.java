package com.green.memoserver;

import com.green.memoserver.config.model.ResultResponse;
import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/memo")
@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;
    //C
    //Post 방식으로 /api/memo
    @PostMapping
    public ResultResponse<Integer> postMemo(@RequestBody MemoPostReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        int result =  memoService.save(req);
        return new ResultResponse<>("삽입 성공", result);
    }
    //R
    @GetMapping
    public ResultResponse<List<MemoGetRes>> getMemo(@ModelAttribute MemoGetReq req) {

//    public String getMemo(@RequestParam(name = "search_text", required = false) String search, @RequestParam Integer page) {
//    MemoGetReq req = MemoGetReq.builder() //스테틱 메소드이다. 객체화를 안 하고 사용할 수 있어서
//                                .searchText(search)
//                                .page(page)
//                                .build();
    log.info("req={}",req);
    List<MemoGetRes> result = memoService.findAll(req);
    String message = String.format("rows: %d", result.size());

        return new ResultResponse<>(message, result);
}

@GetMapping("/{id}")
public ResultResponse<MemoGetOneRes> getMemo(@PathVariable int id) {
    log.info("id={}",id);
    MemoGetOneRes result = memoService.findById(id);

    return new ResultResponse<>("조회 성공", result);
}

//U
@PutMapping
public ResultResponse<Integer> putMemo(@RequestBody MemoPutReq req) {

    log.info("req={}",req);
    int result = memoService.modify(req);
    return new ResultResponse<>("수정 성공", result);

}
//D
@DeleteMapping
public ResultResponse<Integer> deleteMemo(@RequestParam(name = "memo_id",required = false) int id) {
    log.info("id={}", id);
    int result = memoService.deleteById(id);
    return new ResultResponse<>("삭제성공", result);




}


}
