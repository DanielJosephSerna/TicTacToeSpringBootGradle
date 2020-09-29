package cognizant.tictactoe;

import cognizant.tictactoe.model.Game;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TicTacToeApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@BeforeEach
	public void setup() {

	}

	@Test
	void contextLoads() {
	}

	@Test
	void getGame_returnsHumanVsComputerGame() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(get("/setup-game/human-computer"))
				.andExpect(status().isOk())
				.andReturn().getResponse();

		InputStream sampleJson = getClass().getClassLoader().getResourceAsStream("examples/getGame_sampleHumanComputer.json");
		Game expected = objectMapper.readValue(
				sampleJson, new TypeReference<Game>() {
				});

		Game gameResponseEntity = objectMapper.readValue(
				response.getContentAsString(), new TypeReference<Game>(){
					});

		assertEquals(expected, gameResponseEntity);
	}

	@Test
	void getGame_returnsComputerVsHumanGame() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(get("/setup-game/computer-human"))
				.andExpect(status().isOk())
				.andReturn().getResponse();

		InputStream sampleJson = getClass().getClassLoader().getResourceAsStream("examples/getGame_sampleComputerHuman.json");
		Game expected = objectMapper.readValue(
				sampleJson, new TypeReference<Game>() {
				});

		Game gameResponseEntity = objectMapper.readValue(
				response.getContentAsString(), new TypeReference<Game>(){
				});

		assertEquals(expected, gameResponseEntity);
	}

	@Test
	void getGame_returnsHumanVsHumanGame() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(get("/setup-game/human-human"))
				.andExpect(status().isOk())
				.andReturn().getResponse();

		InputStream sampleJson = getClass().getClassLoader().getResourceAsStream("examples/getGame_sampleHumanHuman.json");
		Game expected = objectMapper.readValue(
				sampleJson, new TypeReference<Game>() {
				});

		Game gameResponseEntity = objectMapper.readValue(
				response.getContentAsString(), new TypeReference<Game>(){
				});

		assertEquals(expected, gameResponseEntity);
	}

}
