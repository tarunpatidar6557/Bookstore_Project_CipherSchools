package com.example.demo.bookstoremanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	//get all books
	@RequestMapping("/books")
	public String getAllBooks(Model model) {
		List<Book> booksList = new ArrayList<Book>();
		bookRepository.findAll().forEach((b)->booksList.add(b));
		model.addAttribute("booksList",booksList);
		return "tables";
		//return new ResponseEntity<ArrayList<Book>>(booksList,HttpStatus.OK);
	}
	
	//add books
	@RequestMapping(method=RequestMethod.GET,value = "/add")
	public ResponseEntity<Book> addBooks(@RequestParam String title,@RequestParam String category, @RequestParam String author, @RequestParam String year, @RequestParam String price ) {
		Book book = new Book(null, title, category, author, year, price);
		bookRepository.save(book);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	//update movie
	@RequestMapping(method = RequestMethod.GET, value = "/books/{id}")
	public void updateBook(@PathVariable String id,@RequestParam String title,@RequestParam String category, @RequestParam String author, @RequestParam String year, @RequestParam String price) {
		Book book = new Book(Integer.parseInt(id), title, category, author, year, price);
		bookRepository.save(book);
			
	}
		
	//delete movie
	@RequestMapping(method = RequestMethod.DELETE,value = "/books/{id}")
	public void deleteBook(@PathVariable String id) {
		bookRepository.deleteById(Integer.parseInt(id));
	}
}
