package AlgoView.AlgoView_Server.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Tag(name = "AlgoView API 명세서", description = "API 전체 흐름에 대한 명세서입니다. 이후 엔티티 설계 후 RESTful 형태로 바꿀 예정 ")
@Controller
@RequestMapping("/AlgoView")
@RequiredArgsConstructor
@Slf4j
public class MainController {
    @GetMapping
    @Operation(summary = "메인 페이지 정보 가져오기", description = "사용자 후기 및 관련 이미지를 보여줍니다.")
    public String getReview() throws Exception {
        return "/AlgoView";
    }

    @PostMapping("/reviewForm")
    @Operation(summary = "사용자 후기 등록하기", description = "후기 등록할 때의 요청입니다.")
    public String setReview() throws Exception {
        return "redirect:/AlgoView";
    }

    @GetMapping("/news")
    @Operation(summary = "관련 기사 가져오기", description = "관심사와 관련된 기사를 가져옵니다. ")
    public String getNews(@PathVariable String username) throws Exception {
        return "{username}/news";
    }

    @GetMapping("/users/{username}")
    @Operation(summary = "유저 페이지 가져오기", description = "유저의 과거 분석 결과 및 관련 정보 가져오기")
    public String getUser(@PathVariable String username) throws Exception {
        return "/users/{username}";
    }

    @PostMapping("/upload")
    @Operation(summary = "파일 업로드 및 분석", description = "사용자로부터 파일을 받아 분석을 수행합니다.")
    public String analyzeFile() throws Exception {
        return "redirect:/upload/answer";
    }

    @GetMapping("/results/{analysisId}")
    @Operation(summary = "분석 결과 조회", description = "특정 분석 결과를 조회합니다.")
    public String getAnalysisResult(@PathVariable Long analysisId) throws Exception {
        return "/results/{analysisId}";
    }


}
