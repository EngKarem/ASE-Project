package com.system;

public class PassengersRequests {
    int RequestNum;
    String PassengerName;
    String SrcName;
    String DestName;

    public PassengersRequests(String PassengerName,String SrcName, String DestName,int RequestNum)
    {

        this.RequestNum = RequestNum;
        this.PassengerName = PassengerName;
        this.SrcName = SrcName;
        this.DestName = DestName;
    }
    public int getRequestNum()
    {
        return RequestNum;
    }
}
