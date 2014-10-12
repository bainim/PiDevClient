package com.picturenetwork.client.delegate;

import com.PictureNetwork.persistance.Forum;
import com.PictureNetwork.services.ForumServicesRemote;
import com.picturenetwork.client.locator.ServiceLocator;

public class ForumServiceDelegate {

	private static final String jndiName = "ejb:/PictureNetwork/ForumServices!com.PictureNetwork.services.ForumServicesRemote";

	private static ForumServicesRemote getProxy() {
		return (ForumServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static Forum createForum(Forum forum) {

		return getProxy().createForum(forum);
	}

	public static Forum updateForum(Forum forum) {

		return getProxy().updateForum(forum);
	}

	public static Forum removeForum(Forum forum) {

		return getProxy().removeForum(forum);
	}

}
