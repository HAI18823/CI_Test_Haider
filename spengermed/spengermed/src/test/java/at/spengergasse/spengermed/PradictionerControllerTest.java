package at.spengergasse.spengermed;



import at.spengergasse.spengermed.models.Pradictioner;
import at.spengergasse.spengermed.repository.PradictionerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PradictionerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper om;

    @Test
    public void getAPradictioner(){
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/api/pradictioner/lol"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getAllPradictioner() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/api/pradictioner"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    @Test
    public void getAPradictionerNotFound() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .get("/api/pradictioner/jdljfm"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isNotFound());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void postAPradictioner(){
        
        Pradictioner pradictioner = PradictionerRepositoryTest.returnOnePradictioner();
        String json= null;
        try {
            json = om.writeValueAsString(pradictioner);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/pradictioner/")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void putAPradictioner(){
        Pradictioner pradictioner = PradictionerRepositoryTest.returnOnePradictioner();
        pradictioner.setId("oekhroekhr");
        String json= null;
        try {
            json = om.writeValueAsString(pradictioner);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .put("/api/pradictioner/oekhroekhr")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void putANewPradictioner(){
        Pradictioner pradictioner = PradictionerRepositoryTest.returnOnePradictioner();
        pradictioner.setId("7439re");
        String json= null;
        try {
            json = om.writeValueAsString(pradictioner);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .put("/api/pradictioner/zlft24")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Die id muss es bereits geben.
    // Erwartete Antwort ist 200 (OK
    @Test
    public void deleteAPradictioner(){

        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .delete("/api/pradictioner/lenhjd"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
