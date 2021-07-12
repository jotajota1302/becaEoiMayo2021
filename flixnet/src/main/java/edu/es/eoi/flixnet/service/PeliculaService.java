package edu.es.eoi.flixnet.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.Pelicula;
import edu.es.eoi.flixnet.repository.PeliculaRepository;
import edu.es.eoi.flixnet.repository.PeliculaRepositoryJPAImpl;

public class PeliculaService {

	private static Logger logger= Logger.getLogger(PeliculaService.class);		
	
	private PeliculaRepository repository = new PeliculaRepositoryJPAImpl();
			

	public List<Pelicula> buscarPorActor(Actor actor) {

		logger.info("entro al metodo buscar por actor");
				
		return this.repository.buscarPorActor(actor);
	}

	public List<Pelicula> buscarPorGenero(String genero) throws Exception {
	
		logger.info("entro al metodo buscar por genero");
		
		return this.repository.buscarPorGenero(genero);
	}

	public List<Pelicula> buscarPorNombre(String nombre) {
		
		logger.info("entro al metodo buscar por nombre");
	
		return this.repository.buscarPorNombre(nombre);
	}

	public void reproducir(Pelicula pelicula) {
		// TODO
	}
	
	public void generateExcelPeliculas(List<Pelicula> peliculas) {
		
		
	   Workbook wb = new HSSFWorkbook();               
       Sheet sheet = wb.createSheet("Peliculas");
  
       Map<String, Object[]> data = new TreeMap<String, Object[]>();
       int i=1;
       
       data.put(String.valueOf(i), new Object[] {"NOMBRE", "GENERO"});
        
        for (Pelicula pelicula : peliculas) {
        	 i++;
        	 data.put(String.valueOf(i), new Object[] {pelicula.getNombre(),pelicula.getGenero()});
        }        
   
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
          
            FileOutputStream out = new FileOutputStream(new File("peliculas.xlsx"));
            wb.write(out);
            out.close();
            wb.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		
		
	}
}
