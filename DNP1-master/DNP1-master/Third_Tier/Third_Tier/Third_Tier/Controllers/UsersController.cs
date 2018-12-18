using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Third_Tier.Data;
using Third_Tier.Data.Entities;

namespace Third_Tier.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsersController : ControllerBase
    {
        private readonly UserContext _context;

        public UsersController(UserContext context)
        {
            _context = context;
        }

        // GET: api/Users
        [HttpGet]
        public IEnumerable<User> GetUsers()
        {
            return _context.Users;
        }

        // GET: api/Users/username/Danny Boy
        [HttpGet("username/{UserName}")]
        public async Task<IActionResult> GetUserByUsername([FromRoute] string UserName)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var user = await _context.Users.Where(u => u.username.Equals(UserName)).ToListAsync();

            if (user == null)
            {
                return NotFound();
            }

            return Ok(user);
        }

        // GET: api/Users/email/abc@gmail.com
        [HttpGet("email/{Email}")]
        public async Task<IActionResult> GetUserByEmail([FromRoute] string Email)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var user = await _context.Users.FindAsync(Email);

            if (user == null)
            {
                return NotFound();
            }

            return Ok(user);
        }

        // GET: api/Users/verify/abc@gmail.com/password/password_1
        [HttpGet("verify/email/{Email}/password/{Password}")]
        public async Task<IActionResult> Verify([FromRoute] string Email, [FromRoute] string Password)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }


            var user = await _context.Users.Where(e => e.email.Equals(Email) && e.password.Equals(Password)).ToListAsync();

            if (user == null)
            {
                return NotFound();
            }

            return Ok(user[0]);
        }

        // PUT: api/Users/5
        [HttpPut("update/{Email}")]
        public async Task<IActionResult> PutUser([FromRoute] string Email, [FromBody] User user)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (Email != user.email)
            {
                return BadRequest();
            }

            _context.Entry(user).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!UserExists(Email))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Users/create
        [HttpPost("create")]
        public async Task<IActionResult> PostUser([FromBody] User user)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            _context.Users.Add(user);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetUserByEmail", new { email = user.email }, user);
        }

        // DELETE: api/Users/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteUser([FromRoute] string id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var user = await _context.Users.FindAsync(id);
            if (user == null)
            {
                return NotFound();
            }

            _context.Users.Remove(user);
            await _context.SaveChangesAsync();

            return Ok(user);
        }

        private bool UserExists(string id)
        {
            return _context.Users.Any(e => e.email == id);
        }
    }
}