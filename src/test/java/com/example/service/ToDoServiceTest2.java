package com.example.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.ToDo;
import com.example.repository.ToDoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ToDoServiceTest2 {

	@Mock
	private ToDoRepository toDoRepository;
	
	@InjectMocks
	private ToDoServiceImpl toDoService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetToDoById() {
		ToDo toDo = new ToDo(1, "Todo Sample 1", true);
		when(toDoRepository.findOne(1L)).thenReturn(toDo);
		ToDo result = toDoService.getToDoById(1);
		assertEquals(1, result.getText());
		assertEquals("Todo Sample 1", result.getText());
		assertEquals(true, result.isCompleted());
	}
		
	@Test
	public void testSaveToDo() {
		ToDo toDo = new ToDo(1,"Todo Sample 1", true);
		when(toDoRepository.save(toDo)).thenReturn(toDo);
		ToDo result = toDoService.saveToDo(toDo);
		assertEquals(1, result.getId());
		assertEquals("Todo Sample 1", result.getText());
		assertEquals(true, result.isCompleted());
	}
	
}
