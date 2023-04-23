import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';

function Pagina() {
  return (
    <Box>
      <AppBar position="center">
        <Toolbar>
          <Typography variant="h6" >
            To-Do App
          </Typography>
          </Toolbar>
      </AppBar>
    </Box>
  );
}
export default Pagina;