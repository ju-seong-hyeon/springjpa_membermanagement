package hello.hellospring.controller;

import hello.hellospring.Service.MemberService;
import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    //@Autowired private MemberService memberService;
    //디펜던시 인덱스 - 필드주입
    private final MemberService memberService;
    //private final MemberService = new MemberService()
    //멤버컨트롤러 말고 여러컨트롤러들이 멤버 서비스를 가져다 쓸 수 있음 여러개객체를 생성할 필요가 없음
    // 하나로 공유하면됨 - 스프링컨테이너에 하나만 등록하면됨

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    //디펜던시 인덱스 - 생성자 추천

    //디펜던시 인덱스 - seter주입 public노출해야됌

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        //System.out.println("member = " +member.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
