package com.example.Assignment2_Rest_Manohar_N01661510.controller;

import com.example.Assignment2_Rest_Manohar_N01661510.model.Member;
import com.example.Assignment2_Rest_Manohar_N01661510.repository.MemberRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    // ✅ POST - Add new member
    @PostMapping
    public Member createMember(@Valid @RequestBody Member member) {
        return memberRepository.save(member);
    }

    // ✅ GET - All members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // ✅ GET - Member by ID
    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberRepository.findById(id);
    }

    // ✅ DELETE - Member by ID (optional)
    @DeleteMapping("/{id}")
    public void deleteMemberById(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }

    // ✅ PUT - Update member (optional)
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
        return memberRepository.findById(id)
                .map(member -> {
                    member.setName(updatedMember.getName());
                    member.setEmail(updatedMember.getEmail());
                    member.setMembershipDate(updatedMember.getMembershipDate());
                    return memberRepository.save(member);
                })
                .orElseGet(() -> {
                    updatedMember.setId(id);
                    return memberRepository.save(updatedMember);
                });
    }
}
