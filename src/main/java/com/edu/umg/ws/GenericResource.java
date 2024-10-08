package com.edu.umg.ws;


import com.edu.umg.DAO.AutorDAO;
import com.edu.umg.DAO.EstudianteDAO;
import com.edu.umg.DAO.LibroDAO;
import com.edu.umg.DAO.PrestamosDAO;
import com.edu.umg.DAO.TiposDAO;
import com.edu.umg.Entity.Autor;
import com.edu.umg.Entity.Estudiante;
import com.edu.umg.Entity.Libro;
import com.edu.umg.Entity.Prestamos;
import com.edu.umg.Entity.Tipos;


import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("Updates")
public class GenericResource {

    @Context
    private UriInfo context;
    
    private TiposDAO tiposDAO = new TiposDAO();
    private AutorDAO autorDAO = new AutorDAO();
    private EstudianteDAO estudianteDAO = new EstudianteDAO();
    private LibroDAO librosDAO = new LibroDAO();
    private PrestamosDAO prestamosDAO = new PrestamosDAO();
    
    public GenericResource() {
    }

    @GET
    @Path("Tipos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tipos> getTiposes() {
        return tiposDAO.getAll();
    }

    @PUT
    @Path("/Tipos/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudent(@PathParam("id") int id, Tipos tipos) {
        Tipos existingTipos = tiposDAO.getById(id);
        if (existingTipos != null) {
            tipos.setId(id); // Ensure the ID is preserved
            tiposDAO.update(tipos);
            return Response.ok(tipos).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Path("Autores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Autor> getAutoreses() {
        return autorDAO.getAll();
    }
    
    @PUT
    @Path("/Autores/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAutores(@PathParam("id") int id, Autor autores) {
        Autor existingAutores = autorDAO.getById(id);
        if (existingAutores != null) {
            autores.setId(id); // Ensure the ID is preserved
            autorDAO.update(autores);
            return Response.ok(autores).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    
    @GET
    @Path("Estudiantes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiante> getEstudiantes() {
        return estudianteDAO.getAll();
    }
    
    
    @PUT
    @Path("/Estudiantes/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEstudiantes(@PathParam("id") int id, Estudiante estudiantes) {
        Estudiante existingEstudiantes = estudianteDAO.getById(id);
        if (existingEstudiantes != null) {
            estudiantes.setId(id); // Ensure the ID is preserved
            estudianteDAO.update(estudiantes);
            return Response.ok(estudiantes).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    
    @GET
    @Path("Libros")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Libro> getLibros() {
        return librosDAO.getAll();
    }
    
    @PUT
    @Path("/Libros/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEstudiantes(@PathParam("id") long id, Libro libros) {
        Libro existingLibros = librosDAO.getById(id);
        if (existingLibros != null) {
            libros.setId(id); // Ensure the ID is preserved
            librosDAO.update(libros);
            return Response.ok(libros).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
  @GET
    @Path("Prestamos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prestamos> getPrestamos() {
        return prestamosDAO.getAllPrestamos();
    }
    
    @PUT
    @Path("/Prestamos/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePrestamos(@PathParam("id") Long id, Prestamos prestamos) {
        Prestamos existingPrestamos = prestamosDAO.getPrestamoById(id);
        if (existingPrestamos != null) {
            prestamos.setId(id); // Ensure the ID is preserved
            prestamosDAO.updatePrestamo(prestamos);
            return Response.ok(prestamos).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
