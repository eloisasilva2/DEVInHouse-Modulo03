import * as React from 'react';
import FormControl from '@mui/material/FormControl';
import OutlinedInput from '@mui/material/OutlinedInput';
import Box from '@mui/material/Box';
import Icon from '@mui/material/Icon';



function Formulario() {
  return (
    <Box component="form" noValidate autoComplete="off">
      <FormControl sx={{ width: '100ch', border: '5px solid black' }}>
        <OutlinedInput placeholder="O que você quer fazer?" />
      </FormControl>
      <link
        rel="stylesheet"
        href="https://fonts.googleapis.com/icon?family=Material+Icons"
      />

      <Icon sx={{ fontSize: 100 }}>add_circle</Icon>
    </Box>
  );


}


export default Formulario;