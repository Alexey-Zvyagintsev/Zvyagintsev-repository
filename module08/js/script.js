const addTask = () => {
  const taskInput = document.getElementById("taskInput");
  const task = taskInput.value;

//Проверка не то что есть задача для добавления
  if (!task) return;

  const taskList = document.getElementById("taskList");

  const newTask = document.createElement("div");
  newTask.classList.add("task");

  const taskText = document.createElement("div");
  taskText.classList.add("task-text");
  taskText.innerHTML = task;

  const deleteButton = document.createElement("button");
  deleteButton.innerHTML = "Удалить";
  deleteButton.onclick = () => {
    taskList.removeChild(newTask);
  };

 const checkbox = document.createElement('input');
 checkbox.type = 'checkbox';
 checkbox.style.width = '30px';
 checkbox.style.height = '30px';
 checkbox.addEventListener('change', function() {
 if(this.checked) {
        newTask.style.backgroundColor = 'Gray';
        taskText.style.color = 'White';
  } else {
        newTask.style.backgroundColor = 'LightGray';
        taskText.style.color = 'Black';
  }
 });

  newTask.appendChild(checkbox);
  newTask.appendChild(taskText);
  newTask.appendChild(deleteButton);
  taskList.appendChild(newTask);

  taskInput.value = "";

};