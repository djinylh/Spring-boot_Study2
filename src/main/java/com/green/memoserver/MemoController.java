package com.green.memoserver;

import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("api/memo")
@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;
    //C
    //Post 방식으로 /api/memo
    @PostMapping
    public String postMemo(@RequestBody MemoPostReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        int result =  memoService.save(req);
        return result == 1 ? "저장 성공" : "저장 실패";
    }
    //R
    @GetMapping
    public List<MemoGetRes> getMemo(@ModelAttribute MemoGetReq req) {

//    public String getMemo(@RequestParam(name = "search_text", required = false) String search, @RequestParam Integer page) {
//    MemoGetReq req = MemoGetReq.builder() //스테틱 메소드이다. 객체화를 안 하고 사용할 수 있어서
//                                .searchText(search)
//                                .page(page)
//                                .build();
    log.info("req={}",req);

        return memoService.findAll(req);
}

@GetMapping("{id}")
public MemoGetOneRes getMemo(@PathVariable int id) {
    log.info("id={}",id);

    return memoService.findById(id);
}

//U
@PutMapping
public String putMemo(@RequestBody MemoPutReq req) {

    log.info("req={}",req);

    return "수정완료";

}
//D
@DeleteMapping
public String deleteMemo(@RequestParam(name = "memo_id",required = false) int id) {
    log.info("id={}", id);
    int result = memoService.deleteById(id);

    return result == 1 ? "성공" : "실패";


}


}
