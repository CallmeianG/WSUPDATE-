package com.edu.umg.ws;


import com.edu.umg.dao.AutoresDAO;
import com.edu.umg.dao.TiposDAO;
import com.edu.umg.dao.EstudiantesDAO;
import com.edu.umg.dao.LibrosDAO;
import com.edu.umg.dao.PrestamosDAO;
import com.edu.umg.entities.Prestamos;
import com.edu.umg.entities.Autores;
import com.edu.umg.entities.Estudiantes;
import com.edu.umg.entities.Libros;
import com.edu.umg.entities.Tipos;
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
    private AutoresDAO autoresDAO = new AutoresDAO();
    private EstudiantesDAO estudiantesDAO = new EstudiantesDAO();
    private LibrosDAO librosDAO = new LibrosDAO();
    private PrestamosDAO prestamosDAO = new PrestamosDAO();
    
    public GenericResource() {
    }

    @GET
    @Path("Tipos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tipos> getTiposes() {
        return tiposDAO.getAllTipos();
    }

    @PUT
    @Path("/Tipos/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudent(@PathParam("id") Long id, Tipos tipos) {
        Tipos existingStudent = tiposDAO.getTIposById(id);
        if (existingStudent != null) {
            tipos.setId(id); // Ensure the ID is preserved
            tiposDAO.updateTipos(tipos);
            return Response.ok(tipos).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Path("Autores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Autores> getAutoreses() {
        return autoresDAO.getAllAutores();
    }
    
    @PUT
    @Path("/Autores/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAutores(@PathParam("id") Long id, Autores autores) {
        Autores existingAutores = autoresDAO.getAutoresById(id);
        if (existingAutores != null) {
            autores.setId(id); // Ensure the ID is preserved
            autoresDAO.updateAutores(autores);
            return Response.ok(autores).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    
    @GET
    @Path("Estudiantes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiantes> getEstudiantes() {
        return estudiantesDAO.getAllEstudiantes();
    }
    
    
    @PUT
    @Path("/Estudiantes/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEstudiantes(@PathParam("id") Long id, Estudiantes estudiantes) {
        Autores existingAutores = autoresDAO.getAutoresById(id);
        if (existingAutores != null) {
            estudiantes.setId(id); // Ensure the ID is preserved
            estudiantesDAO.updateAutores(estudiantes);
            return Response.ok(estudiantes).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    
    @GET
    @Path("Libros")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Libros> getLibros() {
        return librosDAO.getAllLibros();
    }
    
    @PUT
    @Path("/Libros/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEstudiantes(@PathParam("id") Long id, Libros libros) {
        Autores existingAutores = autoresDAO.getAutoresById(id);
        if (existingAutores != null) {
            libros.setId(id); // Ensure the ID is preserved
            librosDAO.updateLibros(libros);
            return Response.ok(libros).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Path("Prestamos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prestamos> getLPrestamos() {
        return prestamosDAO.getAllPrestamosList();
    }
    
    @PUT
    @Path("/Prestamos/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePrestamos(@PathParam("id") Long id, Prestamos prestamos) {
        Autores existingAutores = autoresDAO.getAutoresById(id);
        if (existingAutores != null) {
            prestamos.setId(id); // Ensure the ID is preserved
            prestamosDAO.updatePrestamos(prestamos);
            return Response.ok(prestamos).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
