package com.ipiecoles.java.java230;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;

@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeRepository employeRepository;

    @Override
    public void run(String... strings) throws Exception {
    	
    	// ON COMPTE LE NB D'EMPLOYES
    	/*
    	System.out.println("Nombre d'employés : " + employeRepository.count());
    	*/
    	
    	// ON MODIFIE UN EMPLOYE (NOM EN UPPERCASE)
    	/* 
    	Employe emp = employeRepository.findOne(5L);
    	print(emp.toString());
    	emp.setNom(emp.getNom().toUpperCase());
    	employeRepository.save(emp);
    	*/
    	
    	// ON CREE UN NOUVEL EMPLOYE
    	/*
    	Employe newEmp = new Employe("Doe", "John", "M99999", LocalDate.now(), 2000d);
    	print(newEmp.toString());
    	newEmp = employeRepository.save(newEmp);
    	print(newEmp.toString());
    	*/
    	
    	// ON AFFICHE LA LISTE DE TOUS LES EMPLOYES
    	/*
    	List<Employe> emps = (ArrayList)employeRepository.findAll();
    	for(Employe e : emps) {
    		print(e.toString());
    	}
    	*/
    	
    	// ON SUPPRIME L'EMPLOYE QU'ON A CREE
    	/*
    	employeRepository.delete(2504L);
    	*/
    	
    	
    	// LISTER TOUS LES EMPLOYES (avec tri par matricule) AVEC PAGINATION
    	/*
    	Page<Employe> emps = employeRepository.findAll(new PageRequest(0,10, Sort.Direction.ASC, "matricule"));
    	// RENVOIE TOUS LES ELEMENTS
    	// emps.getTotalElements();
    	// RENVOIE TOUTES LES PAGES
    	// emps.getTotalPages();
    	for(Employe e : emps) {
    		print(e.toString());
    	}
    	*/
    	
    	
    	// ESSAI REQUETE DU EMPLOYE REPOSITORY
    	/*
    	List<Employe> employes = employeRepository.findBySalaireGreaterThanOrderBySalaireDesc(1800d);
    	print(employes);
    	*/
    	
    	List<Employe> employes = employeRepository.findByDateEmbaucheAfter(new LocalDate(2016,2,3));
    	print(employes);
    	
    	
    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
