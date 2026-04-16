/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.team_proj_java;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author admin
 */
public class MemberCollectionTest {
    
    public MemberCollectionTest() {
    }
    

    /**
     * Test of addMember method, of class MemberCollection.
     */
    @Test
    public void testAddMember() {
        MemberCollection mc = new MemberCollection();
        Member m = new Member("Ana", "Address", "ana@gmail.com", 0);

        mc.addMember(m);

        assertEquals(1, mc.getMembers().size());
    }

    /**
     * Test of removeMember method, of class MemberCollection.
     */
    @Test
    public void testRemoveMember() {
        MemberCollection mc = new MemberCollection();
        Member m = new Member("Ana", "Address", "ana@gmail.com", 0);

        mc.addMember(m);
        mc.removeMember(m);

        assertEquals(0, mc.getMembers().size());
    }

    /**
     * Test of searchMembers method, of class MemberCollection.
     */
    @Test
    public void testSearchMembers() {
        MemberCollection mc = new MemberCollection();
        Member m1 = new Member("Ana", "Address1", "ana@gmail.com", 0);
        Member m2 = new Member("Luna", "Address2", "luna@gmail.com", 0);

        mc.addMember(m1);
        mc.addMember(m2);

        ArrayList<Member> results = mc.searchMembers("Ana");

        assertEquals(1, results.size());
        assertEquals(m1, results.get(0));
    }

    /**
     * Test of findMemberByEmail method, of class MemberCollection.
     */
    @Test
    public void testFindMemberByEmail() {
    MemberCollection mc = new MemberCollection();

    Member m = new Member("Ana", "Address", "ana@gmail.com", 0);
    mc.addMember(m);

    Member result = mc.findMemberByEmail("ana@gmail.com");

    assertEquals(m, result);
    }

    /**
     * Test of getMembers method, of class MemberCollection.
     */
    @Test
    public void testGetMembers() {
    MemberCollection mc = new MemberCollection();

    Member m = new Member("Ana", "Address", "ana@gmail.com", 0);
    mc.addMember(m);

    assertEquals(1, mc.getMembers().size());
    }
    
}
