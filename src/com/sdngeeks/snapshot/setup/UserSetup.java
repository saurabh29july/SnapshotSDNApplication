package com.sdngeeks.snapshot.setup;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdngeeks.snapshot.models.SnapshotUser;

public class UserSetup {

	@Autowired
	private SessionFactory sessionFactory;

	@PostConstruct
	public void init() {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			SnapshotUser adminUser = (SnapshotUser) session.get(
					SnapshotUser.class, "admin");

			if (adminUser == null) {
				System.err.println("DID NOT FIND ADMIN USER IN DB. CREATING!");

				adminUser = new SnapshotUser();
				adminUser.setUsername("admin");
				adminUser.setFullname("Snapshot Admin");
				adminUser.setPassword("admin");

				session.save(adminUser);

				System.err.println("DID NOT FIND ADMIN USER IN DB. CREATED!");
			} else {
				System.err.println("Found Admin User In DB. NOT CREATING!");
			}

			// Commit the transaction
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			System.err.println("Error while inserting ADMIN USER");
			e.printStackTrace();
		}

	}

}
