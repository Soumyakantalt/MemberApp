package com.nttdata.memberapp.dashboard;

import android.util.Log;
import com.nttdata.memberapp.model.Member;
import java.util.ArrayList;

public class DashboardPresenter {

    private View view;
    Member member;
    ArrayList<Member> memberList = new ArrayList<Member>();

    public DashboardPresenter(View view) {
        this.view = view;
    }

    public void initData() {
        // student 1
        member = new Member("Oliver", "Female", "9456675665", "oliver@gmail.com");
        memberList.add(member);

        //student 2
        member = new Member("George", "Male", "9439871854", "george@gmail.com");
        memberList.add(member);

        //student 3
        member = new Member("Harry", "Male", "9456676666", "harry@gmail.com");
        memberList.add(member);

        //student 4
        member = new Member("Jack", "Male", "9456675555", "jack@gmail.com");
        memberList.add(member);

        //student 5
        member = new Member("Jacob", "Male", "9454445665", "jacob@gmail.com");
        memberList.add(member);

        //student 6
        member = new Member("Noah", "Female", "9453335665", "noah@gmail.com");
        memberList.add(member);

        //student 7
        member = new Member("Charlie", "Male", "9452225665", "charlie@gmail.com");
        memberList.add(member);

        //student 8
        member = new Member("Thomas", "Male", "9456111665", "thomas@gmail.com");
        memberList.add(member);

        //student 9
        member = new Member("Oscar", "Male", "9366675665", "oscar@gmail.com");
        memberList.add(member);

        //student 10
        member = new Member("William", "Male", "9456115665", "william@gmail.com");
        memberList.add(member);

        //student 11
        member = new Member("Henry", "Male", "9066294806", "henry@gmail.com");
        memberList.add(member);

        //student 12
        member = new Member("Freddie", "Female", "9556875665", "freddie@gmail.com");
        memberList.add(member);

        Log.d("response", "initData: " + memberList + "");

        //passing data to interface method addDatas
        view.addDatas(memberList);
    }

    //interface of main activity presenter to add data in arraylist of data model
    public interface View {
        void addDatas(ArrayList<Member> datas);
    }
}
