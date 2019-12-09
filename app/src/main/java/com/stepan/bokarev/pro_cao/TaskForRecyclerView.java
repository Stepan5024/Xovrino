package com.stepan.bokarev.pro_cao;


import androidx.fragment.app.FragmentActivity;

public class TaskForRecyclerView {


    private String taskName;
    private String taskData;
    private String taskTime;
    private int image;
    private int id;
    private int url;
    public FragmentActivity activity;

    public TaskForRecyclerView(String taskName, int id, FragmentActivity activity) {
        this.id = id;
        this.taskName = taskName;


    }


    public void setUrl(int url){
        this.url = url;
    }
    public int getUrl(){
        return this.url;
    }

    public int getID() {
        return this.id;
    }
    public String getTaskData() {
        return this.taskData;
    }

    public String getTaskTime() {
        return this.taskTime;
    }

    public FragmentActivity getActivity() {
        return activity;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setName(String name) {
        this.taskName = name;
    }

    public int getImage() {
        return this.image;
    }

    public void setTaskData(String taskData) {
        this.taskData = taskData;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public void setImage(int image) {
        this.image = image;
    }

}

