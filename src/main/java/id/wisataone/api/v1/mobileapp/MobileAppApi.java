package id.wisataone.api.v1.mobileapp;

import java.util.ArrayList;
import java.util.List;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

import id.wisataone.KonfigurasiApp;
import id.wisataone.model.User;
import id.wisataone.model.UserCtrl;

import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;

@Api(
		name = "mobileapp", 
		title = "API untuk Aplikasi Absensi bagi Aplikasi Wisata One", 
		version = "v1")
public class MobileAppApi {
	@ApiMethod(name="listusers",
			path="user",
			httpMethod=HttpMethod.GET)
	// TODO:pemilik list
	public List<JSONUser> listUsers(@Nullable @Named("offset") Integer offset, @Nullable @Named("limit") Integer limit) {
		List<JSONUser> response = new ArrayList<>();
		// ambil list dari DB melalui controller
		List<User> users = new UserCtrl().listUsers(offset, limit);
		JSONUser jsonUser = null;
		for(User u: users) {
			jsonUser = new JSONUser(u);
			if (jsonUser != null) {
				response.add(jsonUser);	
			}
			jsonUser = null;
		}
		
		return response;
	}
	// TODO:pemilik post
	@ApiMethod(name="create",
			path="user",
			httpMethod=HttpMethod.POST)
	public JSONUser baru(
			JSONUserCreate jsonUserCreate) throws Exception {
		JSONUser response = null;
		
		User user = new UserCtrl().createUser(jsonUserCreate.userName, jsonUserCreate.email);
		
		response = new JSONUser(user);
		
		return response;
	}
	// TODO:pemilik get
	// TODO:pemilik list
	// TODO:pemilik put
	// TODO:pemilik delete

}
