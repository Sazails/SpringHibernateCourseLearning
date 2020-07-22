package org.sazails.controller;

import org.sazails.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {

    private List<Member> members;

    @PostConstruct
    private void loadTestingData(){
        members = new ArrayList<>();
        members.add(new Member(50, "Eva", "Ludwig", "Eva.Ludwig@meMail.org"));
        members.add(new Member(100, "Dom", "Park", "DomPark@email.org"));
    }

    @GetMapping("/list")
    public String listMembers(Model model){
        model.addAttribute("members", members);
        return "list_members";
    }
}
