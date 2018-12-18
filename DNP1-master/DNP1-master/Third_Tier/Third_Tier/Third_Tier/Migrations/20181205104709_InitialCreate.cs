using Microsoft.EntityFrameworkCore.Migrations;

namespace Third_Tier.Migrations
{
    public partial class InitialCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Users",
                columns: table => new
                {
                    email = table.Column<string>(nullable: false),
                    username = table.Column<string>(nullable: true),
                    password = table.Column<string>(nullable: true),
                    score = table.Column<int>(nullable: false),
                    stage = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Users", x => x.email);
                });

            migrationBuilder.InsertData(
                table: "Users",
                columns: new[] { "email", "password", "score", "stage", "username" },
                values: new object[,]
                {
                    { "a@gmail.com", "password1", 5, 0, "John" },
                    { "b@gmail.com", "password2", 87, 5, "Max" },
                    { "c@gmail.com", "password3", 23, 5, "Daniela" },
                    { "d@gmail.com", "password4", 50, 6, "Lukas" },
                    { "e@gmail.com", "password5", 50, 7, "Alex" },
                    { "f@gmail.com", "password6", 46, 4, "Ilie" }
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Users");
        }
    }
}
