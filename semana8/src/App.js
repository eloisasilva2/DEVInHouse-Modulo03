import './App.css';

import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';
import Pagina from './components/Pagina.js';
import Formulario from './components/Formulario.js';

function App() {
  return (
    <div>
      <Pagina/>
        <Formulario />

    </div>
  );
}

export default App;