import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container } from '@mui/system';
import { Paper, Button } from '@mui/material';

export default function Song() {
   const paperStyle ={padding:'50px 20px', width:600, margin:"20px auto"}
   const[name,setName]=React.useState('')
   const[genre,setGenre]=React.useState('')
   const[date,setDate]=React.useState('')
   const[type,setType]=React.useState('')

   const[songs,setSongs]=React.useState([])

   const[artists, setArtists]=React.useState([])


   const handleClick=(e)=>{
        e.preventDefault()
        const artist={name,date,type,genre}
        console.log(artist)
        fetch("http://localhost:8080/api/songcollection",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(artist)
        }).then(()=>{
            console.log("New artist added")
        })
   }

   React.useEffect(()=>{
    fetch("http://localhost:8080/api/songcollection/songs-all")
    .then(res=>res.json())
    .then((result)=>{
        setArtists(result);
    }
    )
   },[])

  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>Add songs</u></h1>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1 },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="Song name" variant="outlined" 
            value={name}
            onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Genre " variant="outlined" 
            value={genre}
            onChange={(e)=>setGenre(e.target.value)}
      />
      <TextField id="outlined-basic" label="Date " variant="outlined" 
            value={date}
            onChange={(e)=>setDate(e.target.value)}
      />

    <TextField id="outlined-basic" label="Type " variant="outlined" 
            value={type}
            onChange={(e)=>setType(e.target.value)}
      />

      <Button variant="contained" onClick={handleClick}>Submit</Button>


    </Box>
      <h1>Add Song</h1>
    <Paper elevation={3} style={paperStyle}>
      {
        artists.map(artist=>(
            <Paper elevation={6} style={{margin:"10px", padding:"15px", textAlign:"left"}} key={artist.songId}>
              {JSON.stringify(artist, null, 4) }
            </Paper>
        ))
      }
    </Paper>
    </Paper>
    </Container>

  );
}
