package com.hasanur.ToDo;

import com.hasanur.ToDo.dao.UserDao;
import com.hasanur.ToDo.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class ToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(UserDao userDao){
		return runner->{
		    while(true){
				System.out.println("\n\n\n1.Register | 2.Login");
				System.out.println("Type 1 for Register User | Type 2 for Login\n");

				Scanner scanner = new Scanner(System.in);
				int userInput = scanner.nextInt();

				if(userInput==1){
					registerUser(userDao);
				}else{
					loginUser(userDao);
				}
			}
		};
	}

	private void registerUser(UserDao userDao){
		System.out.print("First Name: ");
		Scanner scanner = new Scanner(System.in);
		String firstName = scanner.next();

		System.out.print("Last Name: ");
		String lastName = scanner.next();

		System.out.print("Email: ");
		String email = scanner.next();

		System.out.print("Password: ");
		String password = scanner.next();

		//Registering new user

		User user = new User(firstName,lastName,email,password);
		userDao.addUser(user);
		//User has been Registered
		System.out.println("User has been registered");
	}

	private void loginUser(UserDao userDao){
		System.out.print("\nEmail :");
		Scanner scanner = new Scanner(System.in);
		String email = scanner.next();

		User user = userDao.findByEmail(email);

	}

}
