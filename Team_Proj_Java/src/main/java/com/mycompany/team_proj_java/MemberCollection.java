/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.team_proj_java;

import java.util.ArrayList;

public class MemberCollection {

    // list of all members
    private ArrayList<Member> members;

    // constructor
    public MemberCollection() {
        members = new ArrayList<>();
    }

    // add member
    public void addMember(Member member) {
        if (member == null) {
            System.out.println("Member cannot be null");
            return;
        }

        members.add(member);
    }

    // remove member
    public void removeMember(Member member) {
        if (member == null) {
            System.out.println("Member cannot be null");
            return;
        }

        if (!members.contains(member)) {
            System.out.println("Member not found");
            return;
        }

        members.remove(member);
    }

    // search members by name
    public ArrayList<Member> searchMembers(String searchTerm) {
        ArrayList<Member> results = new ArrayList<>();

        if (searchTerm == null || searchTerm.isEmpty()) {
            System.out.println("Invalid search term");
            return results;
        }

        for (Member member : members) {
            if (member != null && member.getName() != null) {
                if (member.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                    results.add(member);
                }
            }
        }

        return results;
    }

    // find member by email
    public Member findMemberByEmail(String email) {
        if (email == null || email.isEmpty()) {
            return null;
        }

        for (Member member : members) {
            if (member != null && member.getEmail() != null) {
                if (member.getEmail().equalsIgnoreCase(email)) {
                    return member;
                }
            }
        }

        return null;
    }

    // getter
    public ArrayList<Member> getMembers() {
        return members;
    }
    
    public boolean isEmpty(){
        return members.isEmpty();
    }
    
    public int size(){
        return members.size();
    }
    
    public Member get(int index){
        if (!(index>=0 && index<members.size())){
            return null;
        }
        return members.get(index);
    }
}
