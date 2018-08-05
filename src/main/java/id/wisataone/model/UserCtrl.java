package id.wisataone.model;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;

import id.wisataone.KonfigurasiApp;

// method static untuk akses Datastore
import static com.googlecode.objectify.ObjectifyService.ofy;

public class UserCtrl {
	/**
	 * Mengambil daftar user yang telah terdaftar
	 * @param offset titik awal data yang diambil
	 * @param limit jumlah data yang diambil
	 * @return daftar user yang telah terdaftar
	 */
	public List<User> listUsers(Integer offset, Integer limit) {
		List<User> users = new ArrayList<>();
		if (offset == null) { 
			offset = KonfigurasiApp.OFFSET;
		}
		if (limit == null) { 
			limit = KonfigurasiApp.LIMIT;
		}
		
		// ambil daftar user 
		users = ofy().load().type(User.class).offset(offset).limit(limit).list();
		return users;
		
	}
	// TODO:pemilik post
	public User createUser(String userName, String email) {
		User user = null;
		
		if (userName != null && !userName.equals("")) {
			if (email != null && !email.equals("")) {
				// dibuat user baru
				user = new User(userName, email);
				// simpan, SEKARANG
				ofy().save().entity(user).now();
				// ambil kembali user yang berhasil disimpan
				user = ofy().load().key(Key.create(User.class, user.getId())).safe();
			}
		}
		
		return user;
	}
	// TODO:pemilik get
	// TODO:pemilik put
	// TODO:pemilik delete
}
