package com.epam.lab.buyit.controller.utils.comparator;

import java.util.Comparator;

import com.epam.lab.buyit.model.User;

public class BidHistoryComparator implements Comparator<User>{

	@Override
	public int compare(User user1, User user2) {
		if(user1.getBidList().get(0).getAmount()  < user2.getBidList().get(0).getAmount()){
            return 1;
        }
        if(user1.getBidList().get(0).getAmount()  > user2.getBidList().get(0).getAmount()){
            return -1;
        }
		return 0;
	}

}
