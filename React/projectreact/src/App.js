import logo from './logo.svg';
import './App.css';
import Appbar from './components/Appbar';
import Artist from './components/Artist';
import Song from './components/Song';
function App() {
  return (
    <div className="App">
      <Appbar/>
      <Artist/>
      <Song/>
    </div>
  );
}

export default App;
