package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

@Controller
@RequestMapping("/autores") //path principal
public class AutorController {

	
	//JSP.-Java Server Page, son las paginas web de tecnologia java
	
	
	@Autowired
	@Qualifier("autorDAOImpl")
	private AutorDAO autorDAO;
	
	@GetMapping("/findAll")   //path secundario
	public String findAll(Model model) {
		//try {
			List<Autor> autores = autorDAO.findAll();
			
			model.addAttribute("Autores", autores);  //	EJ:clave=keyAutors,valor = Autors
			
			return "autores-listar";  //esto es el nombre del formulario Ej,"listar.Autors.html o "listar-Autors.jsp
		
		//} catch (Exception e) {
//       //TODO: handle exception 
			//e.printStackTrace();
		// }
		
	  
	  
		
	
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idAutor") @Nullable Integer idAutor
			             ,@RequestParam("opcion") @Nullable Integer opcion
			             , Model model
			) {
	
		if(idAutor !=null) {
			Autor autor = autorDAO.findOne(idAutor);
			model.addAttribute("Autor", autor);
		}
		
		if(opcion == 1) return "autores-add"; //actualizacion
		else return "autores-del";            //eliminacion
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idAutor")@Nullable Integer idAutor
			         ,@RequestParam("nombre")   @Nullable String nombre
			         ,@RequestParam("apellido") @Nullable String apellido
			         ,@RequestParam("pais") @Nullable String pais
			         ,@RequestParam("direccion")@Nullable String direccion
			         ,@RequestParam("telefono") @Nullable String telefono
			         ,@RequestParam("correo")   @Nullable String correo
			         ,Model model
			) {
		
	//try{
		if(idAutor == null) {
		 Autor autor = new Autor(0,  nombre, apellido, pais, direccion, telefono, correo);
		 autorDAO.add(autor);
	    } else {
	    	Autor autor2  = new Autor(idAutor, nombre, apellido,  pais, direccion, telefono, correo);
	    	autorDAO.up(autor2);
	    }   
	    
	    
		return "redirect:/autores/findAll";
	//}catch (Exception e) {
	//	//TODO: HANDLE exception
//	}
	}
	
    @GetMapping("/del")
    public String del(@RequestParam("idAutor") @Nullable Integer idAutor) {
    	//try{
    
    autorDAO.del(idAutor);
    return "redirect:/autores/findAll";
    // } catch (Exception e) {
    //  //TODO : handle exception
    // }
    }
    
}
