package me.whiteship.redistest.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        //
        this.testService = testService;
    }

    @PostMapping
    public ResponseEntity<?> createData(@RequestParam String key, @RequestParam String data) {
        //
        this.testService.create(key, data);
        return ResponseEntity.ok("insert data ok");
    }

    @PutMapping
    public ResponseEntity<?> updateData(@RequestParam String key, @RequestParam String data) {
        //
        this.testService.update(key, data);
        return ResponseEntity.ok("update data ok");
    }

    @GetMapping
    public ResponseEntity<?> loadData(@RequestParam String key) {
        //
        String data = this.testService.load(key);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping
    public ResponseEntity<?> removeData(@RequestParam String key) {
        //
        this.testService.remove(key);
        return ResponseEntity.ok("delete data ok");
    }
}

// api or RestApi

// get pod delete put patch option ...
// option x   -- tcp/ip에서 cors  교차 플랫폼 검증 - get/...조건 불만족시 option 발행 -- 이런 api가 존재하나요?


// 지켰어?
// get -- 데이터 조회
// post -- 데이터 생성 -- 들고오는 데이터를 wrapping
// put -- 데이터 수정
// patch -- 데이터 일부 수정
// delete -- 데이터 삭제
//request Mapping -- 전부 허용  get/ post

// post -- api만들었다
// post 장점
// 1. security 설정 편함 - 보안 좋다
// 2. custom

